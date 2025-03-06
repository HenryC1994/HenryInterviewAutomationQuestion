package org.example;

import java.sql.*;

import hibernateDBFiles.Equate_Album;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) throws SQLException {
        int num1 = 12;
        boolean flag = (num1 > 11? true: false);
        System.out.println(flag);

        String url = "jdbc:sqlite:chinook.db";
        Connection conn = DriverManager.getConnection(url);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ALBUMS");

       System.out.println(rs);

        while (rs.next()) {
            // Retrieve data by column name or index
            int albumId = rs.getInt("AlbumId"); // Replace with your actual column name
            String title = rs.getString("Title"); // Replace with your actual column name
            int artistId = rs.getInt("ArtistId"); // Replace with your actual column name

            // Process the data as needed
            System.out.println("Album ID: " + albumId);
            System.out.println("Title: " + title);
            System.out.println("Artist ID: " + artistId);
            System.out.println("-----");
        }

        // Create a SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Equate_Album.class)
                .buildSessionFactory();

        // Create a session

        try (factory) {
            Session session = factory.getCurrentSession();
            // Start a transaction
            session.beginTransaction();

            // Retrieve the album with albumId = 2
            int albumId = 2;
            Equate_Album album = session.get(Equate_Album.class, albumId);

            // Check if the album exists and display its details
            if (album != null) {
                System.out.println("Album found: " + album.getTitle());
                System.out.println("Artist ID: " + album.getArtistId());
            } else {
                System.out.println("No album found with ID: " + albumId);
            }

            // Commit the transaction
            session.getTransaction().commit();
        }

        // testng



    }

    public static int addNumbers(int x, int y) {
        return x + y;
    }


}