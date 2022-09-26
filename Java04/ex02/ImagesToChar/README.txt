# Make sure you in ImagesToChar directory:
    pwd

# Create the target and lib directory:
    mkdir lib target

# Download libraries:
    curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
    curl -o lib/JColor-5.5.1.jar https://repo1.maven.org/maven2/com/diogonunes/JColor/5.5.1/JColor-5.5.1.jar

# Compile:
    javac -cp ".:./lib/JColor-5.5.1.jar:./lib/jcommander-1.82.jar" -d ./target/ src/java/edu/school21/printer/*/*.java

# Copy resources
    cp -rf ./src/resources ./target

# Unzip archives:
    cd target ; jar xf ../lib/JColor-5.5.1.jar com ; jar xf ../lib/jcommander-1.82.jar com ; cd ..

# Make jar
    jar cfm ./target/images-to-chars-printer.jar ./src/manifest.txt -C ./target .

# Execute program:
    java -cp ./target edu.school21.printer.app.Program --white=RED --black=GREEN

# Clear:
    rm -rf target lib