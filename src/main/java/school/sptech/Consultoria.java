package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;

public class Consultoria {
    private String nome;
    private Integer vagas;

    private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double valorTotal = 0.0;
        for(Desenvolvedor dev : desenvolvedores){
            valorTotal += dev.calcularSalario();
        }
        return valorTotal;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdDevs = 0;
        for(Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile){
                qtdDevs++;
            }
        }
        return qtdDevs;
    }

    public ArrayList<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        ArrayList<Desenvolvedor> listaDevs = new ArrayList<>();

        for(Desenvolvedor dev : desenvolvedores){
            if(dev.calcularSalario() >= salario){
                listaDevs.add(dev);
            }
        }
        return listaDevs;
    }

    public Desenvolvedor buscarMenorSalario(){

        if(desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor menorDev = desenvolvedores.get(0);

        for(Desenvolvedor dev : desenvolvedores){
            if(dev.calcularSalario() < menorDev.calcularSalario()){
                menorDev = dev;
            }
        }
        return menorDev;
    }

    public ArrayList<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        ArrayList<Desenvolvedor> listaDevPorTecnologias = new ArrayList<>();

        for(Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) dev).getLinguagem().contains(tecnologia) || ((DesenvolvedorMobile) dev).getPlataforma().contains(tecnologia)){
                    listaDevPorTecnologias.add(dev);
                }
            }else if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getBackend().contains(tecnologia) || ((DesenvolvedorWeb) dev).getFrontend().contains(tecnologia) || ((DesenvolvedorWeb) dev).getSgbd().contains(tecnologia)){
                    listaDevPorTecnologias.add(dev);
                }
            }
        }
        return listaDevPorTecnologias;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salarioTotal = 0.0;

        for(Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) dev).getLinguagem().contains(tecnologia) || ((DesenvolvedorMobile) dev).getPlataforma().contains(tecnologia)){
                    salarioTotal += dev.calcularSalario();
                }
            }else if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getBackend().contains(tecnologia) || ((DesenvolvedorWeb) dev).getFrontend().contains(tecnologia) || ((DesenvolvedorWeb) dev).getSgbd().contains(tecnologia)){
                    salarioTotal += dev.calcularSalario();                }
            }
        }
        return salarioTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public ArrayList<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(ArrayList<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
