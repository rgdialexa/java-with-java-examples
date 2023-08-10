# Getting Started

## Java Installation

### OSX
1. Install brew `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
2. Install openjdk 17 `brew install openjdk@17`
3. Make the JDK visiable to the system `sudo ln -sfn /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk`
4. Verify (using terminal that the correct version is installed) `java --version` `javac --version` (These should so something along the lines of java version 17.0.8+0)

#### Testing With Intellij

We're going to do a simple Hello World application in Intellij to make sure it can find the JDK you installed earlier.

1. Open Intellij IDEA CE (Download and install community edition if you haven't already)
2. On the Intellij launch page choose "New Project"
3. Give it a cool name
4. Under JDK selection, click the dropdown and find at the bottom the following selection: `/opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk`
5. Set language to Java, build system to Intellij, and make sure "Add sample code" is checked.
6. Hit 'Create'
7. The project will have a single .java file (src/Main.java)
8. Right click on src/Main and click "Run 'Main.main()'"
9. You should see Hello World print in the console if everything is set up properly.
