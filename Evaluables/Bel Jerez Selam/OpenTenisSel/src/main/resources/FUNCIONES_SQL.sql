-- FUNCION PUNTOS TENISTA

DELIMITER $$
create or replace function getPointsByTenista(in codigo uuid) returns int 
begin 
	return(
	SELECT SUM(ti.puntos) AS totalpuntos
	FROM tenista t
	JOIN torneoganado tg ON t.codigo = tg.codTenista
	JOIN torneo ti ON tg.codTorneo = ti.codigo
	WHERE t.codigo = codigo
	GROUP BY t.codigo, t.nombre
);
end
$$
DELIMITER ;


select getPointsByTenista('[UUID]');







-- PROCEDIMIENTO SPONSORS DE TENISTAS

DELIMITER $$
create or replace procedure getTenistaWithSponsor()
begin 
	SELECT tenista.nombre as nombreTenista, sponsor.nombre as nombreSponsor
	FROM tenista
	INNER JOIN tenistacontrato ON tenista.codigo = tenistacontrato.codTenista
	INNER JOIN contrato ON contrato.codigo = tenistacontrato.codContrato
	INNER JOIN sponsor ON sponsor.codigo = contrato.codSponsor;
end
$$
DELIMITER ;


call getTenistaWithSponsor();






-- PROCEDIMIENTO SPONSORS RICOS

DELIMITER $$
create or replace procedure getRichSponsors()
begin 
	SELECT s.codigo, s.nombre
	FROM sponsor s
	JOIN contrato c ON s.codigo = c.codSponsor
	GROUP BY s.codigo, s.nombre
	HAVING SUM(c.saldo) > 1000000;
end
$$
DELIMITER ;

call getRichSponsors();

