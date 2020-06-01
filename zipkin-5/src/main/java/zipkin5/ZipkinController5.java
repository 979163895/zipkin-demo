package zipkin5;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
@RequestMapping("zipkin")
public class ZipkinController5 {


    @GetMapping("/service5")
    public String service() throws Exception {
        return execSql();
    }


    public String execSql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/gin?user=root&password=123456&useSSL=false&useUnicode=true&characterEncoding=UTF-8&statementInterceptors=brave.mysql.TracingStatementInterceptor&zipkinServiceName=myDatabaseService5";
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            String sql = "select * from tb where id = 1";
            resultSet = statement.executeQuery(sql);

            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                return resultSet.getString(1);
            }
        } catch (Throwable t) {
            // TODO 处理异常
            t.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("成功关闭资源");
        }
        return "no data";
    }
}

