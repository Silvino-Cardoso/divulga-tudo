package com.ads.entities;

/**Classe para cadastro de anuncios e calculo de relatorio de visualizacoes
 * @author Silvino Cardoso
 */

import com.sun.istack.NotNull;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "tb_ads")
public class Ads {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String adName;

    @NotNull
    private String clientName;

    @NotNull
    private String initialDate;

    @NotNull
    private String finalDate;

    @NotNull
    private double dailyInvestment;

    private double totalInvestment;

    private double totalViews;
    private double originalViews;
    private double click;
    private double shared;
    private double viewsByShare;
    private double totalViewsCalc;


    /* getters and setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public double getDailyInvestment() {
        return dailyInvestment;
    }

    public void setDailyInvestment(double dailyInvestment) {
        this.dailyInvestment = dailyInvestment;
    }

    public double getTotalInvestment() {
      return totalInvestment;
    }

    public double getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(double totalViews) {
        this.totalViews = totalViews;
    }

    public double getOriginalViews() {
        return originalViews;
    }

    public void setOriginalViews(double originalViews) {
        this.originalViews = originalViews;
    }

    public double getClick() {
        return click;
    }

    public void setClick(double click) {
        this.click = click;
    }

    public double getShared() {
        return shared;
    }

    public void setShared(double shared) {
        this.shared = shared;
    }

    public double getViewsByShare() {
        return viewsByShare;
    }

    public void setViewsByShare(double sharedViews) {
        this.viewsByShare = sharedViews;
    }

    public double getTotalViewsCalc() {
        return totalViewsCalc;
    }

    public void setTotalViewsCalc(double totalViewsCalc) {
        this.totalViewsCalc = totalViewsCalc;
    }


    /* Metodo para calcular valor total do investimento, recebe as data iniciasi e finais, calcula a diferenca
    * de dias entre elas, adiciona 1 dia ( para considerar o dia inicial no calculo) e multiplica pelo valor
    * diario de investimento
    * @param dateOne e dateTwo - Data inicial e data final do anuncio
    * @return  double - Valor total investido no anuncio
    * */
    public double setTotalInvestment(String dateOne , String dateTwo) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate = sdf.parse(dateOne);
        Date secondDate = sdf.parse(dateTwo);
        long mill = Math.abs(firstDate.getTime() - secondDate.getTime());
        long totalDays = TimeUnit.DAYS.convert(mill,TimeUnit.MILLISECONDS) + 1;
        return this.totalInvestment = totalDays * dailyInvestment ;
    }

    /*Metodo para calculo do total de visualizacoes, multiplicamos o total de investimento por 30, que e
    * a quantidade de visualizacoes referentes a R$ 1,00 investido. Consideramos que 12% das visualizacoes
    *  resultam em clicks e que 15% dos click resultam em compartilhamento. Multiplicamos os compartilhamentos
    * por 40 valo informado de visualizacoes para cada compartilhamento
    * @return  double - total de visualizaoes do anuncio
    */
    public Double calculTotalViews(){
        originalViews = Math.floor(totalInvestment * 30);
        click = Math.floor(originalViews * 0.12);
        shared = Math.floor(click * 0.15);
        viewsByShare = Math.floor(shared * 40);
        totalViewsCalc = Math.floor(viewsByShare + originalViews);
        return this.totalViews = totalViewsCalc;
    }


}
