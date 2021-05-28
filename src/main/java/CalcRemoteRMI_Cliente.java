//Gersson Gerardo Chavarría Escorcia.
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gersson
 */
public class CalcRemoteRMI_Cliente 
{
 
    public static void main(String args[]) throws RemoteException
    {
        
        CalcRemoteRMI_Cliente  Obj_CalcCliente  = new CalcRemoteRMI_Cliente();
        Obj_CalcCliente.Metodo_CalcCliente();
        
    }
    
    private void Metodo_CalcCliente() throws RemoteException
    {
        Scanner Obj_ClassScanner = new Scanner(System.in);
        //int Ent1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer valor"));
        //int Ent2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo valor"));
        int Ent1;
        int Ent2;
        int Opcion;// =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la opcion a operar"));
        int Respuesta = 0; //int Metodo_Interface_Resta = 0;
                    

        while(true){
         try
        {
            //String IP = JOptionPane.showInputDialog("Intrusca la IP del servidor.");
            Registry VarRemote = LocateRegistry.getRegistry("localhost", 1099);
            InterfaceCalcRemoteRMI Obj_a_la_Interface = (InterfaceCalcRemoteRMI) VarRemote.lookup("Identificador_del_Servidor");
            
            
            do
            {
                JOptionPane.showMessageDialog(null,"Por favor introduzca dos numeros a operar: ");
              //Ent1 = Obj_ClassScanner.nextInt();
              //Ent2 = Obj_ClassScanner.nextInt();
                Ent1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer valor"));
                Ent2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo valor"));
                do
                {
           
                 Opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Qué operacion desea calcular?\n 1) Suma\n 2) Resta\n 3) Multiplicación\n 4) División")); 
                    
                    if(Opcion > 4)
                    {
                        
                        JOptionPane.showMessageDialog(null,"No existe una opercaion con esa opción");
                        
                    }
                    
                }while(Opcion>4);
                
                if(Opcion == 4 && Ent1 == 0 || Ent2==0)
                {
                    JOptionPane.showMessageDialog(null,"Division invalida devido a division entre 0");
                    
                }
                
            }while(Opcion==4 && Ent1 == 0 || Ent2==0);
            
            switch(Opcion)
            {
             
                case 1:
                    Respuesta = Obj_a_la_Interface.Metodo_Interface_Suma(Ent1, Ent2);
                    break;
                    
                case 2:
                    Respuesta = Obj_a_la_Interface.Metodo_Interface_Resta(Ent1, Ent2);
                    break;
                
                case 3:
                    Respuesta = Obj_a_la_Interface.Metodo_Interface_Multiplicacion(Ent1, Ent2);
                    break;
                    
                case 4:
                    Respuesta = Obj_a_la_Interface.Metodo_Interface_Division(Ent1, Ent2);
                    break;
                
            }
            
            JOptionPane.showMessageDialog(null,"La repuesta de la oparacion es: " + Respuesta);
        }
        catch(NotBoundException | RemoteException Valor_Excepcion)
        {
            JOptionPane.showMessageDialog(null,"Se encontró una excepcion" + Valor_Excepcion);
            
        }
           
        }
        
        
    }
    
}
