find . -name "*.java" > src.txt
javac -sourcepath . @src.txt
java simulation.weather.Simulation scenario.txt