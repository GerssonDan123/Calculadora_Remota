//Gersson Gerardo Chavarría Escorcia.
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
//import java.net.InetAddress;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gersson
 */
public class CalcRemoteRMI_Servidor extends UnicastRemoteObject implements InterfaceCalcRemoteRMI
{
    public CalcRemoteRMI_Servidor() throws RemoteException
    {
        super();
    }
    
    @Override
    public int Metodo_Interface_Suma(int Valor_1, int Valor_2) throws RemoteException 
    {
        int Suma = Valor_1 + Valor_2;   
        
        return Suma;
    }

    @Override
    public int Metodo_Interface_Resta(int Valor_1, int Valor_2) throws RemoteException
    {
        int Resta = Valor_1 - Valor_2;
        
        return Resta;
        
    }        
    
    @Override
    public int Metodo_Interface_Multiplicacion(int Valor_1, int Valor_2) throws RemoteException
    {
        
        int Multiplicacion = Valor_1 * Valor_2;
        
        return Multiplicacion;
        
    }        
    
    @Override
    public int Metodo_Interface_Division(int Valor_1, int Valor_2) throws RemoteException
    {
        
        int Division = (Valor_1 / Valor_2);
        
        return Division;
        
    }  

    public static void main(String args[]) throws RemoteException
    {
        try
        {
            String ComprobadorDireccion = (InetAddress.getLoopbackAddress()).toString();
            Registry VarRemote = LocateRegistry.createRegistry(1099);
            VarRemote.rebind("Identificador_del_Servidor", new CalcRemoteRMI_Servidor());
           JOptionPane.showMessageDialog(null,"El servidor está en proceso");
        }
        catch(RemoteException Valor_Excepcion)
        {
          JOptionPane.showMessageDialog(null,"");
        }    
    
    }

    
}
