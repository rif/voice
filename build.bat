@echo off

echo Build Process
echo -------------

if "%JAVA_HOME%" == "" goto error

set ANT_HOME=.\dev\ant
set ANT_LIB=%ANT_HOME%\lib

set LOCALCLASSPATH=%JAVA_HOME%\lib\tools.jar;%ANT_LIB%\ant.jar;%ANT_LIB%\ant-optional.jar;%ANT_LIB%\junit.jar;%ANT_LIB%\jaxp.jar;%ANT_LIB%\xerces.jar;%ANT_LIB%\xalan.jar;%ANT_LIB%\bsf.jar

echo Building with classpath %LOCALCLASSPATH%
echo Starting Ant...

java -classpath %LOCALCLASSPATH% org.apache.tools.ant.Main -buildfile %ANT_HOME%\xml\build.xml %1 %2 %3 %4 %5 %6

goto end

:error
echo "ERROR: JAVA_HOME not found in your environment."
echo "Please, set the JAVA_HOME variable in your environment to match the location of the Java Virtual Machine you want to use."

:end