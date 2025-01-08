import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager  {


    private static volatile ConfigurationManager instance;
    private final Map <String, String> properties;

    private ConfigurationManager(){
        properties = new HashMap<>();

    }

    public static ConfigurationManager getInstance(){
        if(instance == null){
            instance = new ConfigurationManager();
            synchronized (ConfigurationManager.class){
                if(instance == null){
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }


    public void setProperty(String key, String value){
        properties.put(key, value);
    }

    public String getProperty(String key){
        return properties.getOrDefault(key, "Kein Schlüssel");
    }

    public void printAllProperties(){
        if(properties.isEmpty()){
            System.out.println("Keine Konfigurationen gespeichert");
        } else {
            System.out.println(properties);
        }
    }

    public static void main(String[] args) {

        // Objekt erzeugen
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Properties setzen
        configManager.setProperty("1", "XRP");
        configManager.setProperty("2", "XLM");
        configManager.setProperty("3", "HBAR");

        // Methode aufrufen, um Key zu bekommen
        System.out.println("Coin: " + configManager.getProperty("1"));
        System.out.println("Alle Konfigurationen:");
        configManager.printAllProperties();

        // Checken, ob alles die gleiche Instanz hat
        System.out.println(ConfigurationManager.getInstance().toString());
        System.out.println(ConfigurationManager.getInstance().toString());

    }
}



