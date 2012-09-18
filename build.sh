echo "Build Process"
echo "-------------"

if [ -z $JAVA_HOME ]; then
    echo "ERROR: JAVA_HOME not found in your environment."
    echo "Please, set the JAVA_HOME variable in your environment to match the location of the Java Virtual Machine you want to use."
    exit 1
fi

ANT_HOME=./dev/ant
ANT_LIB=${ANT_HOME}/lib

#add all jars from lib to JARS
JARS=`find ${ANT_LIB} -name '*jar' | while read JAR_FILE; do \
    echo -n ":$JAR_FILE"; \
done`
LOCALCLASSPATH=${JAVA_HOME}/lib/tools.jar${JARS}

echo "Building with classpath ${LOCALCLASSPATH}"
echo "Starting Ant..."

java -classpath ${LOCALCLASSPATH} org.apache.tools.ant.Main -buildfile ${ANT_HOME}/xml/build.xml $@