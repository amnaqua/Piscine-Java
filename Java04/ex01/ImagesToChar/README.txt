# Make sure you in ImagesToChar directory:
    pwd

# Create the target directory:
    mkdir target

# Compile .java files into .class files:
    javac -d ./target/ src/java/edu/school21/printer/*/*.java

# Copy resources:
    cp -R ./src/resources ./target/resources

# Make jar:
    jar cvfm target/Program.jar src/manifest.txt -C target .

# Run jar:
    java -jar target/Program.jar . 0

# Clear
    rm -rf target