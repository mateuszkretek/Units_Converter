module com.units_converter {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;


	opens com.units_converter to javafx.fxml;
	exports com.units_converter;
}