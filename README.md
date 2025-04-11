# Distributed Shared Memory Project

## Prerequisites

Before building or running the project, make sure the following tools are installed:

- **Maven** – Used for building the project. Verify with:
  ```bash
  mvn --version
  ```

- **Make** – Required to compile the project.

- **Java** – A compatible Java version must be installed.

- **Terminal Emulator** – (e.g., `gnome-terminal`) is required to launch multiple terminal windows automatically.

---

## Building the Project

To compile the project and generate the executable JAR file:

1. Open a terminal in the **root directory** of the project.

2. Run:
   ```bash
   make
   ```

   This command uses Maven to build the project and will generate the following JAR file:

   ```
   target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar
   ```

---

## Running the Project

### Step 1 – Start the Configuration Server

- In your project directory, run the script:
  ```bash
  ./run-configserver.sh
  ```

- The configuration server distributes the node configuration to all nodes.  
  **Keep this terminal open** while the project is running.

---

### Step 2 – Launch Nodes and Clients Together

- Open a **new terminal window**.

- In the project directory, run:
  ```bash
  ./launch.sh
  ```

- This script will open separate terminal windows to launch the following nodes in order:

  ```
  NodeA, NodeA1, NodeA2, NodeB, NodeB1, NodeB2
  ```

- After all nodes start, the script will also launch **two clients**:
  - One using `client1_requests.txt`
  - One using `client2_requests.txt`

---

## Alternative – Running Nodes and Clients Individually

If you prefer to start each component separately, use the provided scripts:

### To Run an Individual Node

Open a **terminal window for each node** and type:

```bash
./run-node.sh NodeA
./run-node.sh NodeA1
./run-node.sh NodeA2
./run-node.sh NodeB
./run-node.sh NodeB1
./run-node.sh NodeB2
```

Each command starts `NodeMain` for the specified node with the JAR file:

```
target/Distributed_Shared_Memory-1.0-SNAPSHOT.jar
```

on the classpath.

---

### To Run a Client Individually

Open a **new terminal window** for each client and type:

```bash
./run-client.sh client1_requests.txt
./run-client.sh client2_requests.txt
```

Each command launches a `Client` process using the provided request file.
