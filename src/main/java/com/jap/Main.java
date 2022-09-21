package com.jap;

import com.jap.model.Song;
import com.jap.repository.SongRepository;
import com.jap.service.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice = -1;

        do {

            System.out.println("Welcome to the songplay System");

            System.out.println("1. Add a new song");
            System.out.println("2. View all songs");
//            System.out.println("3. View a salesperson by ID");
//            System.out.println("4. Update a salesperson's commission rate by ID");
//            System.out.println("5. Update a salesperson's city by ID");
//            System.out.println("6. Delete a salesperson by ID");
//            System.out.println("7. Exit");
//            System.out.println("============================================");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            DatabaseService databaseService = new DatabaseService();

            try {
                databaseService.connect();

                SongRepository songRepository = new SongRepository();

                Connection connection = databaseService.getConnection();

                switch (choice) {
                    case 1:
                        System.out.println("Add a new song");
                        System.out.println("Enter the songId ");

                        int songId = scanner.nextInt();
                        System.out.println("Enter the song name: ");

                        String songName = scanner.next();

                        System.out.println("Enter the albumName: ");

                        String albumName = scanner.next();

                        System.out.println("Enter the songGenre: ");

                        String genre = scanner.next();
                        System.out.println("Enter the artistName: ");
                        String artistName = scanner.next();
                        System.out.println("Enter the songPath: ");
                        String songPath = scanner.next();

                        Song song = new Song(songId, songName, albumName, genre, artistName, songPath);

                        songRepository.addSong(connection, song);
                        break;
                    case 2:
                        System.out.println("View all salespersons");

                        songRepository.displayAllSongs(connection).forEach(System.out::println);

                        break;
//                    case 3:
//                        System.out.println("View a salesperson by ID");
//
//                        System.out.println("Enter the salesperson's ID: ");
//
//                        int salesId = scanner.nextInt();
//
//                        Salesperson salesperson1 = salespersonRepository.getById(connection, salesId);
//
//                        if (salesperson1.getSalesId() == 0) {
//                            System.err.println("No salesperson found with the given ID");
//                        } else {
//                            System.out.println(salesperson1);
//                        }
//
//                        break;
//                    case 4:
//                        System.out.println("Update a salesperson's commission rate by ID");
//
//
//                        System.out.println("Enter the salesperson's ID: ");
//
//                        salesId = scanner.nextInt();
//
//                        Salesperson salesperson2 = salespersonRepository.getById(connection, salesId);
//
//                        if (salesperson2.getSalesId() == 0) {
//                            System.err.println("No salesperson found with the given ID");
//                            break;
//                        } else {
//                            System.out.println("Enter the salesperson's new commission rate: ");
//
//                            commissionRate = scanner.nextDouble();
//
//                            boolean b = salespersonRepository.updateCommissionRate(connection, salesId, commissionRate);
//
//                            if (b) {
//                                System.out.println("Salesperson's commission rate updated successfully");
//                            } else {
//                                System.err.println("No salesperson found with the given ID");
//                            }
//
//                        }
//
//                        break;
//                    case 5:
//                        System.out.println("Update a salesperson's city by ID");
//
//                        System.out.println("Enter the salesperson's ID: ");
//
//                        salesId = scanner.nextInt();
//
//                        Salesperson salesperson3 = salespersonRepository.getById(connection, salesId);
//
//                        if (salesperson3.getSalesId() == 0) {
//                            System.err.println("No salesperson found with the given ID");
//                            break;
//                        } else {
//                            System.out.println("Enter the salesperson's new city: ");
//
//                            city = scanner.next();
//
//                            boolean result = salespersonRepository.updateCity(connection, salesId, city);
//
//                            if (result) {
//                                System.out.println("Salesperson's city updated successfully");
//                            } else {
//                                System.err.println("No salesperson found with the given ID");
//                            }
//
//                        }
//
//                        break;
//                    case 6:
//                        System.out.println("Delete a salesperson by ID");
//
//                        System.out.println("Enter the salesperson's ID: ");
//
//                        salesId = scanner.nextInt();
//
//                        Salesperson salesperson4 = salespersonRepository.getById(connection, salesId);
//
//                        if (salesperson4.getSalesId() == 0) {
//                            System.err.println("No salesperson found with the given ID");
//                        } else {
//                            boolean b = salespersonRepository.deleteById(connection, salesId);
//
//                            if (b) {
//                                System.out.println("Salesperson deleted successfully");
//                            } else {
//                                System.err.println("No salesperson found with the given ID");
//                            }
//                        }
//
//                        break;
                    case 3:
                        System.out.println("Exit");
                        break;
                    default:
                        System.err.println("Invalid choice");
                }

            } catch (SQLException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
                ;
            }

        } while (choice != 3);
    }

}
