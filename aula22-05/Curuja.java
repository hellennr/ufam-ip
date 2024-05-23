public class Curuja
     
     private float velocidadeMaxima;

     Curuja(float velocidadeMaxVia){
          this.setVelocidadeMaxima(velMaxVia);
     }



     public float getVelocidadeMaxima(){
          return this.velocidadeMaxima;
     }

     public void setVelocidadeMaxima(float novoValor){
          this.velocidadeMaxima = novoValor;
     }

     public float calculaMulta(float velocidadeAferida){
          float velMaxVia, velVeiculo,delta,multa;

          velMaxVia = this.getVelocidadeMaxima();
          velVeiculo = velocidadeAferida;

          delta = velVeiculo - velMaxVia;

      if(delta >0.0f){
          if(delta <= velMaxVia*(0.2)){
        multa = 200.0f;
    }
        else{
            if(delta <= velMaxVia*(0.5)){
                multa = 500.0f;
            }        
        }
        else{
            multa = 2000.0f;
        }
    else{
        multa = 0.0f;
    }
     }
     return multa;