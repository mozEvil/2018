package remote.client;

import remote.server.Service;
import remote.server.ServiceServer;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Женя on 18.07.2017.
 */
public class ServiceBrowser {
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;

    public static void main(String[] args) {
        new ServiceBrowser().buildGui();
    }

    public void buildGui() {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        Object[] services = getServicesList();

        serviceList = new JComboBox(services);
        frame.getContentPane().add(BorderLayout.NORTH, serviceList);
        serviceList.addActionListener(e -> event_serviceList());

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private void event_serviceList() {
        Object selection = serviceList.getSelectedItem();
        loadService(selection);
    }

    void loadService(Object serviceSelection) {
        try {
            Service service = server.getService(serviceSelection);

            mainPanel.removeAll();
            mainPanel.add(service.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private Object[] getServicesList() {
        Object o = null;
        Object[] services = null;

        try {
            o = Naming.lookup("rmi://127.0.0.1/ServiceServer");

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

        server = (ServiceServer) o;

        try {
            services = server.getServiceList();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return services;
    }

}
