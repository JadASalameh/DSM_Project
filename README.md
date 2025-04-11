Running the Distributed Shared Memory Project

This guide provides step-by-step instructions to compile and run the Distributed Shared Memory project. Please ensure your environment meets the prerequisites before starting.
Prerequisites

    Maven: Ensure Maven is installed on your system. Verify installation by running:

    mvn --version

    Make: The project uses a Makefile for compilation. Ensure make is installed.

    Terminal Emulator: The provided scripts use terminal commands (e.g., gnome-terminal). Modify them if you use a different terminal emulator.

    Java: Make sure you have a compatible version of Java installed.

Building the Project

    Open a terminal in the root directory of the project.

    Run the following command to compile the entire project using Maven and the Makefile:

make

This will compile the code and generate the JAR file at:

    target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar

Running the Project
Step 1: Start the Configuration Server

    In the project directory, run the configuration server script:

    ./run-configserver.sh

    The configuration server is responsible for providing configuration details (such as node information) to all nodes.
    Keep this terminal open because the configuration server must be running before launching any nodes.

Step 2: Launch Nodes and Clients Together

    Open a new terminal window.

    From the project directory, execute the script that launches all nodes and clients at once:

    ./launch.sh

    This script opens separate terminal windows for each node and for two client processes. The nodes will start in the following order:

        NodeA, NodeA1, NodeA2, NodeB, NodeB1, NodeB2, NodeD, NodeD1, NodeD2
        After the nodes are up, two clients are launched, with each client reading from client1_requests.txt or client2_requests.txt respectively.

Alternative: Run Each Node and Client Separately

If you prefer to run each node or client individually, separate scripts are provided:
Running Nodes Individually

You can run any node separately using the run-node.sh script. Open a new terminal for each node and execute:

./run-node.sh NodeA
./run-node.sh NodeA1
./run-node.sh NodeA2
./run-node.sh NodeB
./run-node.sh NodeB1
./run-node.sh NodeB2
./run-node.sh NodeD
./run-node.sh NodeD1
./run-node.sh NodeD2

Each command will start the corresponding node using:

java -cp "target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar":. NodeMain <NodeName>

Running Clients Individually

Similarly, you can run clients individually using the run-client.sh script. Open a new terminal for each client and execute:

./run-client.sh client1_requests.txt
./run-client.sh client2_requests.txt

Each command will start a client with the specified request file:

java -cp "target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar":. Client <request_file>

Summary

    Ensure prerequisites are met: Install Maven, Make, a terminal emulator, and a compatible Java version.

    Build the project: Run make in the project directory.

    Start the configuration server: Run ./run-configserver.sh and keep that terminal open.

    Launch nodes and clients together: Open a new terminal and run ./launch.sh.

    (Optional) Run nodes and clients individually:

        Use ./run-node.sh <NodeName> for nodes.

        Use ./run-client.sh <request_file> for clients.

Following these steps will compile the project and properly launch the configuration server, nodes, and clients, allowing you to test the Distributed Shared Memory system.
