@echo off
echo ====================================
echo  SISTEMA DO PROFESSOR CARLOS
echo ====================================
echo.

echo Compilando o sistema...
javac SistemaProfessor.java Aluno.java

if errorlevel 1 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo.
echo Executando o sistema...
echo.
java SistemaProfessor

pause