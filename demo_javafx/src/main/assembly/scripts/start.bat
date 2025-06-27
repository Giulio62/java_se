@echo off
set PATH="%~dp0";%PATH%
java.exe --module-path "%~dp0..\lib" --add-modules javafx.controls,javafx.fxml --module com.example.demo.demojavafx/com.example.demo.MainApp %*
pause