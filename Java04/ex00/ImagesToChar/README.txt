# Make sure you in ImagesToChar directory:
    pwd

# Create target directory:
    mkdir target

# Compile .java files into .class files:
    javac -d ./target src/java/edu/school21/printer/*/*.java

# Launch program:
    java -classpath ./target edu.school21.printer.app.Program . 0 ./it.bmp

# Clear:
    rm -rf target