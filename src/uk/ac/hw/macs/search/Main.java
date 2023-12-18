package uk.ac.hw.macs.search;

public class Main {
    public static Node[][] ConfigGrid(int gridY, int gridX, char[][] mazeConfiguration, int gridGoalStateX, int gridGoalStateY ) {

        Node[][] maze = new Node[gridY][gridX];

        for (int row = 0; row < gridY; row++) {
            for (int col = 0; col < gridX; col++) {

                //Initializing the state
                IntState state = new IntState(col, row, gridGoalStateX, gridGoalStateY);
                //Initializing the node with the state
                maze[row][col] = new Node(state);
            }
        }


        for (int row = 0; row < gridY; row++) {
            for (int col = 0; col < gridX; col++) {
                // Add relationships to valid neighbors (up, down, left, right)

                // Calculate the cost of moving from the current node to the neighbor node

                int neighborCost = 1;

                if (row - 1 >= 0) {
                    if (mazeConfiguration[row - 1][col] == '3') {
                        neighborCost = 3;
                    }
                    else {
                        neighborCost = 1;
                    }

                    if (!(mazeConfiguration[row - 1][col] == 'X')) {
                        maze[row][col].addChild(maze[row - 1][col], neighborCost);
                    }


                }

                if (row + 1 <= gridY - 1) {
                    if (mazeConfiguration[row + 1][col] == '3') {
                        neighborCost = 3;
                    }
                    else {
                        neighborCost = 1;
                    }

                    if (!(mazeConfiguration[row + 1][col] == 'X')) {
                        maze[row][col].addChild(maze[row + 1][col], neighborCost);
                    }


                }

                if (col - 1 >= 0) {
                    if (mazeConfiguration[row][col - 1] == '3') {
                        neighborCost = 3;
                    }
                    else {
                        neighborCost = 1;
                    }

                    if (!(mazeConfiguration[row][col - 1] == 'X')) {
                        maze[row][col].addChild(maze[row][col - 1], neighborCost);
                    }


                }

                if (col + 1 <= gridX - 1) {
                    if (mazeConfiguration[row][col + 1] == '3') {
                        neighborCost = 3;
                    }
                    else {
                        neighborCost = 1;
                    }

                    if (!(mazeConfiguration[row][col + 1] == 'X')) {
                        maze[row][col].addChild(maze[row][col + 1], neighborCost);
                    }


                }
            }
        }

        return maze;
    }

    public static void main(String[] args) {

        //Grid Size for Grid 1 & 2
        int gridOneX = 6;
        int gridOneY = 4;

        int gridTwoX = 5;
        int gridTwoY = 5;

        //Goal States for Grid 1 & 2
        int gridOneGoalStateX = 4;
        int gridOneGoalStateY = 3;

        int gridTwoGoalStateX = 4;
        int gridTwoGoalStateY = 4;

        //start node is always (0,0)

        //CASE 1 : GRID 1
        char[][] mazeConfiguration = {
                {'S', '3', '.', '.', '.', '.'},
                {'.', '3', 'X', '.', '3', '.'},
                {'.', '.', '3', 'X', '3', '.'},
                {'.', '.', '.', 'X', 'G', '.'},
        };

        char[][] mazeConfiguration2 = {
                { 'S', '.', '.', '.', '.' },
                { '3', 'X', 'X', 'X', '3' },
                { '.', '.', 'X', '.', '.' },
                { 'X', '.', '3', '.', '3' },
                { '.', '.', '.', '.', 'G' },
        };

        Node[][] maze = new Node[gridOneY][gridOneX];
        Node[][] mazeTwo = new Node[gridTwoY][gridTwoX];

        //int gridY, int gridX, Node[][] maze, char[][] mazeConfiguration, int gridGoalStateX, int gridGoalStateY
        Node[][] configMaze = ConfigGrid(gridOneY, gridOneX, mazeConfiguration, gridOneGoalStateX, gridOneGoalStateY );
        Node[][] configMazeTwo = ConfigGrid(gridTwoY, gridTwoX, mazeConfiguration2, gridTwoGoalStateX, gridTwoGoalStateY);

        SearchOrder order = new AStarSearchOrder();
        SearchProblem problem = new SearchProblem(order);

        // Run the search on Maze 1
        System.out.println("Maze 1:");
        problem.doSearch(configMaze[0][0]);

        //Run the search on Maze 2
        System.out.println("\nMaze 2:");
        problem.doSearch(configMazeTwo[0][0]);


    }
}
