package fi.bingo.gameinfoservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

import fi.bingo.gameinfoservice.models.BingoCoupon;
import fi.bingo.gameinfoservice.models.Game;
import fi.bingo.gameinfoservice.models.SavedBingoRound;

@RestController
@RequestMapping("/games")
public class GameResource {
    
    @Value("${application.bingo.database.url}")
    private String url;
    @Value("${application.bingo.database.username}")
    private String user;
    @Value("${application.bingo.database.password}")
    private String password;

    private DatabaseHelper dbh = new DatabaseHelper();

    @RequestMapping("/{gameId}")
    public Game getGameWithSystemId(@PathVariable("gameId") Integer gameId){
        return new Game(gameId, "Testi peli");
    }

    @CrossOrigin
    @RequestMapping("/allgames")
    public List<Game> getAllGames(){

        Connection conn = dbh.connectToDb(url, user, password);

        String query = "SELECT * FROM games";
        ResultSet rs = dbh.makeQueryToDb(conn, query);

        List<Game> listGames = makeList(rs);

        return listGames;
    }

    @CrossOrigin
    @RequestMapping("/savePlayedRound")
    public SavedBingoRound postSaveBingoGame(@RequestBody SavedBingoRound sbr){

        List<BingoCoupon> sbrBc = sbr.getBingoCoupons();
        List<Integer> sbrDn = sbr.getDrawnNumbers();

        try {

            Connection conn = dbh.connectToDb(url, user, password);

            // createNewPlayedBingoId(conn);
            // Integer bingoGameId = getLastBingoGameId(conn);



            // String sql = "INSERT INTO mytable (column1, column2) VALUES (?, ?)";
            // PreparedStatement pstmt = conn.prepareStatement(sql);

            // for(BingoCoupon bc  : sbrBc) {
            //     pstmt.setString(1, "value1");
            //     pstmt.setInt(2, 123);
            //     pstmt.addBatch();
            //     System.out.println(bc.getGame().getName());
            // }

            // int[] rowsAffected = pstmt.executeBatch();

            conn.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return sbr;
    }

    public Integer getLastBingoGameId(Connection conn){
        
        Integer bingoGameId = -1;

        try {

            String playedBingoGamesId = "SELECT * FROM playedbingogames ORDER BY id DESC";
            ResultSet rs = dbh.makeQueryToDb(conn, playedBingoGamesId);
            rs.next();
            bingoGameId = rs.getInt("id");
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return bingoGameId;
    }

    public void createNewPlayedBingoId(Connection conn){
        
        try {

            String playedBingoGamesSQL = "INSERT INTO playedbingogames VALUES (DEFAULT, DEFAULT)";
            PreparedStatement pstmt = conn.prepareStatement(playedBingoGamesSQL);
            pstmt.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Game> makeList(ResultSet rs){
        List<Game> gameList = new ArrayList<>();
        
        try {
            while (rs.next()) {
                Game game = new Game(
                    rs.getInt("id"),
                    rs.getString("name")
                );
                gameList.add(game);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return gameList;
    }
}
