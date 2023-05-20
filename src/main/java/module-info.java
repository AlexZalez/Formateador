module com.proyecto.formateador {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.proyecto.formateador to javafx.fxml;
    exports com.proyecto.formateador;
}
