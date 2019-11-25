//package com.tema2.main;
import fileio.FileSystem;

import java.util.ArrayList;

final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }


    GameInput load() {
        Integer nrLines = 0;
        Integer nrColumns;
        ArrayList<ArrayList<Character>> gameMap = new ArrayList<>();
        Integer nrOfPlayers = 0;
        Integer nrRounds = 0;
        ArrayList<ArrayList<Character>> directions = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        String race;
        int xCoordinate;
        int yCoordinate;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            nrLines = fs.nextInt();
            fs.nextInt();
            // Creating Map
            for(Integer i = 0; i < nrLines; ++i) {
                ArrayList<Character> myArray = new ArrayList<Character>();
                String myString = fs.nextWord();
                char[] moves = myString.toCharArray();
                for(char iterator : moves) {
                    myArray.add(iterator);
                }
                gameMap.add(i, myArray);
            }

            // Creating Players
            nrOfPlayers = fs.nextInt();
            for (Integer i = 0; i < nrOfPlayers; ++i) {
                    race = fs.nextWord();
                    xCoordinate = fs.nextInt();
                    yCoordinate = fs.nextInt();
                    Player player = new Player();
                    player.setType(race);
                    player.setCoordinateX(xCoordinate);
                    player.setCoordinateY(yCoordinate);
                    player.setTerrain(gameMap.get(xCoordinate).get(yCoordinate));
                    players.add(player);
            }

            nrRounds = fs.nextInt();
            for (Integer i = 0; i < nrRounds; ++i) {
                ArrayList<Character> myArray = new ArrayList<>();
                String myString = fs.nextWord();
                char[] direction = myString.toCharArray();
                for (char iterator : direction) {
                    myArray.add(iterator);
                }
                directions.add(i, myArray);
            }

            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return  new GameInput(gameMap, nrOfPlayers, players, nrRounds, directions);
    }
}
