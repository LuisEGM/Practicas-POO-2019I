package gestionDeAgendas;

import java.time.LocalDate;
import java.util.LinkedList;

public class Programa {

    public static void main(String[] args) {
        
        /*Crea una agenda básica cuyo propietario sea “Enrique” y como descripción “tutorías”.*/
        AgendaBasica agenda1 = new AgendaBasica("Enrrique","Tutorias");
        
        /*Para esa agenda, establece los siguientes turnos:
            o 12 de diciembre de 2018: “09:30 – 10:00” y “10:30 – 11:00”.
            o 13 de diciembre de 2018: “10:30 – 11:00”*/
        LocalDate fecha1 = LocalDate.of(2018,12,12);
        agenda1.agregarUnTurno(fecha1,"09:30 – 10:00");
        agenda1.agregarUnTurno(fecha1,"10:30 – 11:00");
        
        LocalDate fecha2 = LocalDate.of(2018,12,13);
        agenda1.agregarUnTurno(fecha2,"10:30 – 11:00");
        
        /*Crea una agenda balanceada cuyo propietario sea “Enrique” y descripción “Revisión de examen”.*/
        AgendaBalanceada agenda2 = new AgendaBalanceada("Enrique","Revisión de examen");
        
        /*12 de diciembre de 2018: “12:00 – 12:30” y “13:30 – 14:00”.
        o 13 de diciembre de 2018: “11:00 – 11:30”, “12:30 – 13:00” y “13:00 –
        13:30”.*/
        agenda2.agregarUnTurno(fecha1,"12:00 – 12:30");
        agenda2.agregarUnTurno(fecha1,"13:30 – 14:00");
        
        agenda2.agregarUnTurno(fecha2,"11:00 – 11:30");
        agenda2.agregarUnTurno(fecha2,"12:30 – 13:00");
        agenda2.agregarUnTurno(fecha2,"13:00 – 13:30");
        
        //Añade las agendas anteriores a una lista de agendas.
        LinkedList<Agenda> agendas = new LinkedList<>();
        agendas.add(agenda1);
        agendas.add(agenda2);
        
        /*Recorre la lista de agendas y para cada una de ellas:*/
        
        int i=1;
        
        Turno aux1 = null;
        Turno aux2 = null;
        
        AgendaBalanceada copia = null;
        
        for(Agenda a: agendas){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  EJECUCIÓN # "+i+"  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            
            //o Muestra por la consola su descripción.
            System.out.println("»» Descripcción: "+a.getDescripcion());
            
            //o Muestra por la consola el número de turnos del 13 de diciembre.
            System.out.println("»» Turnos del 13 de diciembre: "+a.consultarTurnosDeUnDia(fecha2).size());
            
            
            /*o El usuario “Juan” hace dos reservas automáticas. Muestra por la
            consola los turnos que se han reservado.*/
            aux1 = a.hacerReserva("Juan");
            System.out.println(aux1);
            
            aux2 = a.hacerReserva("Juan");
            System.out.println(aux2);
            
            /*o Recorre los turnos del 13 de diciembre y muestra por la consola los
            turnos (toString) que estén ocupados.*/
            System.out.println("###################  Turnos de 13 de diciembre ocupados  ###################\n");
            
            for(Turno t: a.consultarTurnosDeUnDia(fecha2)){
                if(a.consultarSiUnTurnoEstaOcupado(t)){
                    System.out.println(t.toString());
                }
            }
            
            //o El usuario “Juan” cancela el primero de los turnos que ha reservado.
            a.cancelarReserva(aux1,"Juan");
            
            /*o Por último, si la agenda es balanceada:
                ▪ Muestra el día con mayor disponibilidad.
                ▪ Crea una copia y retrasa una semana los turnos de la copia.
                ▪ Muestra por la consola los turnos de la copia (toString).*/
            
            if(a instanceof AgendaBalanceada){
                
                System.out.println("# Dia con mayor disponibilidad: "+((AgendaBalanceada) a).diasConMasTurnosDisponibles());
                copia = (AgendaBalanceada) a.clone();
                copia.ajustarDias(7);
                
            }
            
            System.out.println("\n\n");
            i++;
        }
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   COPIA DE AGENDA BALANCEADA RETRASA UNA SEMANA   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        for(Turno t: copia.getTurnos()){
            System.out.println(t.toString());
        }
        
    }
    
}
