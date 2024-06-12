package inteface;

public class Company implements CompanyServ{
    @Override
    public int rank(int rank) {
        return rank >= 2 ? 4 : 1;
    }
}
