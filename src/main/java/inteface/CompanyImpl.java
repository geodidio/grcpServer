package inteface;

public class CompanyImpl implements CompanyServ{
    @Override
    public int rank(int rank) {
        return rank >= 2 ? 4 : 1;
    }
}
