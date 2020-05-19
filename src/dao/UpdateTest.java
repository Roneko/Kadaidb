package dao;
//mysql　自分の使うクラスを持ってくる
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

    public int update(String name, int age , int id) {
        // データベース接続と結果取得のための変数　※決まり事
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int cnt = 0;

        try {
            // 1. ドライバのクラスをJava上で読み込む　※決まり事
            Class.forName("com.mysql.jdbc.Driver");

            // 2. DBと接続する
            con = DriverManager.getConnection(
            	"jdbc:mysql://localhost/kadaidb?useUnicode=true&characterEncoding=UTF-8",
                "root",
                ""//パスワード
            );// "password"の部分は，ご自身でrootユーザーに設定したものを記載してください。

            // 3. DBとやりとりする窓口（Statementオブジェクト）の作成　※決まり事
            stmt = con.createStatement();

            // 4, 5. Update文の実行と結果を格納／代入
            cnt = stmt.executeUpdate("UPDATE person SET name='"+name +"', age="+age+" where id="+id);//""のなかでスペース


        } catch (SQLException e) {
            // DBとの処理で何らかのエラーがあった場合の例外
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            // JDBCドライバを読み込めないエラーがあった場合の例外
            e.printStackTrace();

        } finally {
            // 7. 接続を閉じる
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return cnt;
    }
}