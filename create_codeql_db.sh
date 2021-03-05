#!/bin/bash

rm -rf codeql-db
#codeql database create codeql-db --language=xml #--command="mvn clean install"

# include all xml files
# see https://github.com/github/codeql/issues/3887
codeql database init --source-root=. --language java codeql-db
codeql database trace-command --working-dir=. codeql-db $(codeql resolve extractor --language=java)/tools/autobuild.sh
find . -name target | xargs rm -rf
codeql database index-files --language xml --include-extension .xml --working-dir=. codeql-db
codeql database finalize codeql-db
