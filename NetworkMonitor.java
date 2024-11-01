import java.util.ArrayList;
import java.util.List;

// Sujeito
class NetworkMonitor {
    private List<NetworkObserver> observers = new ArrayList<>();
    private String status;

    public void addObserver(NetworkObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NetworkObserver observer) {
        observers.remove(observer);
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
        notifyObservers();
    }

    private void notifyObservers() {
        for (NetworkObserver observer : observers) {
            observer.update(status);
        }
    }

    public static void main(String[] args) {
        NetworkMonitor monitor = new NetworkMonitor();
        NetworkObserver observer = new StatusDisplay();

        monitor.addObserver(observer);
        monitor.setStatus("Connected");
    }
}

// Observador
interface NetworkObserver {
    void update(String status);
}

class StatusDisplay implements NetworkObserver {
    @Override
    public void update(String status) {
        System.out.println("Network status: " + status);
    }
}
