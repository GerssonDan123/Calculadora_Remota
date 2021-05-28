//Gersson Gerardo Chavarría Escorcia.
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gersson
 */
public interface InterfaceCalcRemoteRMI extends Remote
{
    public int Metodo_Interface_Suma(int Valor_1, int Valor_2) throws RemoteException;
    public int Metodo_Interface_Resta(int Valor_1, int Valor_2) throws RemoteException;
    public int Metodo_Interface_Multiplicacion(int Valor_1, int Valor_2) throws RemoteException;
    public int Metodo_Interface_Division(int Valor_1, int Valor_2) throws RemoteException;
}

