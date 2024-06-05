@echo off

if not defined JAVA_HOME (
    if exist "C:\Users\%USERNAME%\.jdks\jdk-17.0.6\bin\java.exe" (
        set JAVA_HOME=C:\Users\%USERNAME%\.jdks\jdk-17.0.6\
    ) else (
            set /p JAVA_HOME="Enter the path to your Java 17 installation (e.g., C:\Users\%USERNAME%\.jdks\jdk-17.0.6): "
    )
)


if not exist "%JAVA_HOME%\bin\java.exe" (
    echo Invalid JAVA_HOME path. Please make sure Java 17 is installed in the specified directory.
    pause
    exit /b 1
)

set PATH=%JAVA_HOME%\bin;%PATH%

cd /d %~dp0

mvnw.cmd clean install