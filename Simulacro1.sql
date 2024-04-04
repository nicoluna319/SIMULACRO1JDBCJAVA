CREATE DATABASE hospital;
USE hospital;

CREATE TABLE Especialidad (
    id_especialidad INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    PRIMARY KEY (id_especialidad)
);

CREATE TABLE Medico (
    id_medico INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    id_especialidad INT,
    PRIMARY KEY (id_medico),
    FOREIGN KEY (id_especialidad) REFERENCES Especialidad(id_especialidad)
);

CREATE TABLE Paciente (
    id_paciente INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    fecha_nacimiento DATE,
    documento_identidad VARCHAR(255),
    PRIMARY KEY (id_paciente)
);

CREATE TABLE Cita (
    id_cita INT AUTO_INCREMENT,
    id_paciente INT,
    id_medico INT,
    fecha_cita DATE,
    hora_cita TIME,
    motivo VARCHAR(255),
    PRIMARY KEY (id_cita),
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente),
    FOREIGN KEY (id_medico) REFERENCES Medico(id_medico)
);