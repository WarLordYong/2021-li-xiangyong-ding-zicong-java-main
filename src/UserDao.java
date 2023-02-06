public interface UserDao {
    //注册
    public abstract void regist(User user);
    //登录
    public abstract boolean isLogin(String userName,String passWord);

}
