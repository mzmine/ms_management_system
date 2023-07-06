//Next flow for ChEBI

params {
    chebiSdfFile = '/C:/Users/shaam/Downloads/Compressed/ChEBI_complete.sdf.gz'
    dbUrl = 'jdbc:postgresql://localhost:5432/postgres'
    dbUser = 'postgres'
    dbPassword = 'root'
}

process importToDatabase {
input:
file chebiSdf from file(params.chebiSdfFile)

script:
"""
psql ${params.dbUrl} -U ${params.dbUser} -c 'CREATE TABLE IF NOT EXISTS chebi (
id SERIAL PRIMARY KEY,
compound_id VARCHAR(20),
compound_name VARCHAR(200),
mass FLOAT,
charge FLOAT,
formula VARCHAR(50),
structure TEXT
);'

gunzip ${chebiSdf}

psql ${params.dbUrl} -U ${params.dbUser} -c "COPY chebi (compound_id, compound_name, mass, charge, formula, structure)
FROM '${chebiSdf.stripSuffix('.gz')}' (FORMAT 'csv', DELIMITER '\t');"

psql ${params.dbUrl} -U ${params.dbUser} -c 'VACUUM ANALYZE chebi;'
"""
}

workflow {
importToDatabase()
}
