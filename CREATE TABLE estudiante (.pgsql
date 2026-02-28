CREATE TABLE estudiante (
    id_estudiante SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    numero_documento VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    id_programa INTEGER,
    
    CONSTRAINT fk_programa
        FOREIGN KEY (id_programa)
        REFERENCES programa(id_programa)
        ON DELETE SET NULL
);


INSERT INTO estudiante (nombre, numero_documento, email, id_programa)
VALUES
('Tania', NULL, 'tatiana@gmail.com', 1);

Select *from estudiante;


INSERT INTO programa (nombre)
VALUES 
('Enfermeria'),
('Ingeniero ambiental'); 




CREATE TABLE curso(
    id_curso SERIAL PRIMARY KEY,
    nombre VARCHAR (100) NOT NULL UNIQUE
);

INSERT INTO curso(nombre) VALUES
('Habilidades de poder'),
('Ingles'),
('Programacion'),
('Frontend Angular'),
('BD postgres');

SELECT * FROM curso;

--SELECT oid, datname FROM pg_detabase;

CREATE TABLE matricula(
    fecha DATE NOT NULL DEFAULT CURRENT_DATE,
    
    id_estudiante_fk INTEGER NOT NULL,
    id_curso INTEGER NOT NULL,
    
    PRIMARY KEY(id_estudiante_fk, id_curso),
    
    CONSTRAINT fk_matricula_estudiante
        FOREIGN KEY (id_estudiante_fk)
        REFERENCES estudiante(id_estudiante)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_matricula_curso
        FOREIGN KEY (id_curso)
        REFERENCES curso(id_curso)
        ON DELETE CASCADE

);


SELECT * FROM matricula;

SELECT (id_estudiante_fk, id_curso) as llave_primaria, fecha, id_estudiante_fk, id_curso FROM matricula

INSERT INTO matricula(id_estudiante_fk, id_curso) VALUES
(1,2)

--SELECT conname
--FROM information_schema.table_constraints
--WHERE table table_name ='matricula'
--AND constraint_type= 'UNIQUE'

SELECT
  e.id_estudiante AS id,
  e.nombre AS estudiante,
  pr.nombre AS programa
FROM estudiante e
JOIN programa pr ON pr.id_programa = e.id_programa
ORDER BY e.id_estudiante;