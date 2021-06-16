public class Usuario {

    private String username;
    private String password;

    public void Usuario(String username, String password){
        this.username=username;
        this.password=password;
    }

    public void Listar(int i) {

            System.out.println("\n\t----------User "+i+"-------------------");
            System.out.println("> Username: " + username + "     ");
            System.out.println("> Password: " + password + "     ");

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
