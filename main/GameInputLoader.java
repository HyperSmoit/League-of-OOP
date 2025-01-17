package main;
import fileio.FileSystem;
import heroes.Player;
import heroes.Rogue;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Wizard;

import java.util.ArrayList;

final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;
    private FileSystem fs = null;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
        try {
            fs = new FileSystem(mInputPath, mOutputPath);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public FileSystem getFs() {
        return fs;
    }

    GameInput load() {
        Integer nrLines;
        ArrayList<ArrayList<Character>> gameMap = new ArrayList<>();
        Integer nrOfPlayers = 0;
        Integer nrRounds = 0;
        ArrayList<ArrayList<Character>> directions = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        String race;
        int xCoordinate;
        int yCoordinate;

        try {
            nrLines = fs.nextInt();
            fs.nextInt();

            // Creating Map
            for (Integer i = 0; i < nrLines; ++i) {
                ArrayList<Character> myArray = new ArrayList<Character>();
                String myString = fs.nextWord();
                char[] moves = myString.toCharArray();
                for (char iterator : moves) {
                    myArray.add(iterator);
                }
                gameMap.add(i, myArray);
            }

            // Creating Players
            nrOfPlayers = fs.nextInt();
            for (Integer i = 0; i < nrOfPlayers; ++i) {
                    race = fs.nextWord();
                    yCoordinate = fs.nextInt();
                    xCoordinate = fs.nextInt();
                    if (race.equals("R")) {
                        Player player = new Rogue();
                        player.setType(race);
                        player.setCoordinateX(xCoordinate);
                        player.setCoordinateY(yCoordinate);
                        player.setTerrain(gameMap.get(xCoordinate).get(yCoordinate));
                        players.add(player);
                    } else if (race.equals("W")) {
                        Player player = new Wizard();
                        player.setType(race);
                        player.setCoordinateX(xCoordinate);
                        player.setCoordinateY(yCoordinate);
                        player.setTerrain(gameMap.get(xCoordinate).get(yCoordinate));
                        players.add(player);
                    } else if (race.equals("K")) {
                        Player player = new Knight();
                        player.setType(race);
                        player.setCoordinateX(xCoordinate);
                        player.setCoordinateY(yCoordinate);
                        player.setTerrain(gameMap.get(xCoordinate).get(yCoordinate));
                        players.add(player);
                    } else {
                        Player player = new Pyromancer();
                        player.setType(race);
                        player.setCoordinateX(xCoordinate);
                        player.setCoordinateY(yCoordinate);
                        player.setTerrain(gameMap.get(xCoordinate).get(yCoordinate));
                        players.add(player);
                    }
            }
            nrRounds = fs.nextInt();
            int playerNumber = 0;
            for (Integer i = 0; i < nrRounds; ++i) {
                ArrayList<Character> myArray = new ArrayList<>();
                String myString = fs.nextWord();
                char[] direction = myString.toCharArray();
                for (char iterator : direction) {
                    myArray.add(iterator);
                    players.get(playerNumber).getDirections().add(iterator);
                    playerNumber++;
                }
                directions.add(i, myArray);
                playerNumber = 0;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return  new GameInput(gameMap, nrOfPlayers, players, nrRounds, directions);
    }
}
