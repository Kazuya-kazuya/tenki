package tenki;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        InBean ib = new InBean();
        ib.setTorihikisakiName("セントラル商会");
        ib.setTorihikiDate( LocalDate.of(2018, 5, 2) );
        ib.setGoukei(400);

        ib.getLines().add(  new InLineBean("消しゴム",1,100) );
        ib.getLines().add(  new InLineBean("鉛筆",20,300) );

        OutBean ob = tenki( ib );
        System.out.println( ob.toString() );
    }

    public String toString() {
        return "Main []";
    }

    static OutBean tenki( InBean ib)
    {
//    	-1.転記元の最初のページを用意する。
        InBean inBean = ib;

//    	0.転記先の最初のページを用意する。
        OutBean outBean = new OutBean();

        label1:{

//    		1.日付を見る。
            LocalDate inDate = inBean.getTorihikiDate();

//    		2.日付を写す。
            outBean.setTorihikiDate(inDate);

//    		3.取引先を見る。
            String inTorihikisakiName = inBean.getTorihikisakiName();

//    		4.取引先を写す。
            outBean.setTorihikisakiName(inTorihikisakiName);

//    		5.テーブルの枠を見る。
//    		6.テーブルの枠を写す。
//    		7.テーブルの属性を見る。
//    		8.テーブルの属性を写す。

//    		9.テーブルの1行目を見る。
            InLineBean number1Data;
            try {
                number1Data = inBean.getLines().get(0);
            }

//    		10.1行目が無ければ24へ。
            catch(IndexOutOfBoundsException e) {
                break label1;
            }

//    		11.テーブルの1行目を写す。
            OutLineBean number1DataCopy = new OutLineBean();
            number1DataCopy.setShouhinName(number1Data.getShouhinName());
            number1DataCopy.setSuuryo(number1Data.getSuuryo());
            number1DataCopy.setKingaku(number1Data.getKingaku());
            outBean.getLines().add(0, number1DataCopy);

//    		12.テーブルの2行目を見る。
            InLineBean number2Data;
            try {
                number2Data = inBean.getLines().get(1);
            }

//    		13.2行目が無ければ24へ。
            catch(IndexOutOfBoundsException e) {
                break label1;
            }

//    		14.テーブルの2行目を写す。
            OutLineBean number2DataCopy = new OutLineBean();
            number2DataCopy.setShouhinName(number2Data.getShouhinName());
            number2DataCopy.setSuuryo(number2Data.getSuuryo());
            number2DataCopy.setKingaku(number2Data.getKingaku());
            outBean.getLines().add(0, number2DataCopy);

//    		15.テーブル3行目を見る。
            InLineBean number3Data;
            try {
                number3Data = inBean.getLines().get(2);
            }

//    		16.3行目が無ければ24へ。
            catch(IndexOutOfBoundsException e) {
                break label1;
            }

//    		17.テーブルの3行目を写す。
            OutLineBean number3DataCopy = new OutLineBean();
            number3DataCopy.setShouhinName(number3Data.getShouhinName());
            number3DataCopy.setSuuryo(number3Data.getSuuryo());
            number3DataCopy.setKingaku(number3Data.getKingaku());
            outBean.getLines().add(0, number3DataCopy);

//    		18.テーブルの4行目を見る。
            InLineBean number4Data;
            try {
                number4Data = inBean.getLines().get(3);
            }

//    		19.4行目が無ければ24へ。
            catch(IndexOutOfBoundsException e) {
                break label1;
            }

//    		20.テーブルの4行目を写す。
            OutLineBean number4DataCopy = new OutLineBean();
            number4DataCopy.setShouhinName(number4Data.getShouhinName());
            number4DataCopy.setSuuryo(number4Data.getSuuryo());
            number4DataCopy.setKingaku(number4Data.getKingaku());
            outBean.getLines().add(0, number4DataCopy);

        }

//    	21.転記元の次のページを用意する。
//    	22.転記先の次のページを用意する。
//    	23.1へ

//    	24.合計金額を見る。
        int goukei = inBean.getGoukei();

//    	25.合計金額を写す。
        outBean.setGoukei(goukei);

        return outBean;
    }

}
//------------------------------------
class InBean
{
    private LocalDate 			torihikiDate;
    private String	  			torihikisakiName;
    private int		  			goukei;
    private List<InLineBean> 	lines= new ArrayList<InLineBean>();

    public LocalDate getTorihikiDate() {
        return torihikiDate;
    }
    public void setTorihikiDate(LocalDate torihikiDate) {
        this.torihikiDate = torihikiDate;
    }
    public String getTorihikisakiName() {
        return torihikisakiName;
    }
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }
    public int getGoukei() {
        return goukei;
    }
    public void setGoukei(int goukei) {
        this.goukei = goukei;
    }
    public List<InLineBean> getLines() {
        return lines;
    }



}
class InLineBean
{
    private String shouhinName;
    private int		suuryo;
    private int		kingaku;



    public InLineBean(String shouhinName, int suuryo, int kingaku) {
        super();
        this.shouhinName = shouhinName;
        this.suuryo = suuryo;
        this.kingaku = kingaku;
    }
    public String getShouhinName() {
        return shouhinName;
    }
    public void setShouhinName(String shouhinName) {
        this.shouhinName = shouhinName;
    }
    public int getSuuryo() {
        return suuryo;
    }
    public void setSuuryo(int suuryo) {
        this.suuryo = suuryo;
    }
    public int getKingaku() {
        return kingaku;
    }
    public void setKingaku(int kingaku) {
        this.kingaku = kingaku;
    }


}
//------------------------------------
class OutBean
{
  private LocalDate 			torihikiDate;
  private String	  			torihikisakiName;
  private int		  			goukei;
  private List<OutLineBean> 	lines= new ArrayList<OutLineBean>();

    public LocalDate getTorihikiDate() {
        return torihikiDate;
    }
    public void setTorihikiDate(LocalDate torihikiDate) {
        this.torihikiDate = torihikiDate;
    }
    public String getTorihikisakiName() {
        return torihikisakiName;
    }
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }
    public int getGoukei() {
        return goukei;
    }
    public void setGoukei(int goukei) {
        this.goukei = goukei;
    }
    public List<OutLineBean> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "OutBean [torihikiDate=" + torihikiDate + ", torihikisakiName=" + torihikisakiName + ", goukei=" + goukei
                + ", lines=" + lines + "]";
    }

}
//------------------------------------
class OutLineBean
{
  private String shouhinName;
  private int		suuryo;
  private int		kingaku;
    public String getShouhinName() {
        return shouhinName;
    }
    public void setShouhinName(String shouhinName) {
        this.shouhinName = shouhinName;
    }
    public int getSuuryo() {
        return suuryo;
    }
    public void setSuuryo(int suuryo) {
        this.suuryo = suuryo;
    }
    public int getKingaku() {
        return kingaku;
    }
    public void setKingaku(int kingaku) {
        this.kingaku = kingaku;
    }

    @Override
    public String toString() {
        return "OutLineBean [shouhinName=" + shouhinName + ", suuryo=" + suuryo + ", kingaku=" + kingaku + "]";
    }


}