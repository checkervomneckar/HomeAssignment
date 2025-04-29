import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import CostChart from './CostChart';

function transformiereDaten(rohdaten) {
    const zusammengefasst = {};

    rohdaten.flat().forEach(({ meteringPointAddr, costsPerMonth }) => {
        Object.entries(costsPerMonth).forEach(([monat, kosten]) => {
            if (!zusammengefasst[monat]) zusammengefasst[monat] = { monat };
            zusammengefasst[monat][meteringPointAddr] = kosten;
        });
    });

    return Object.values(zusammengefasst).sort((a, b) => a.monat.localeCompare(b.monat));
}

function StatistikSeite() {
    const { customer_id } = useParams();
    const [daten, setDaten] = useState([]); // daten: React-Komponenten-State-Variable

    useEffect(() => {
        if (!customer_id) return;
        fetch(`http://localhost:8080/Christina/electric/${customer_id}`)// Endpoint der Backend-Daten
            .then(response => response.json())
                .then(data => {
                console.log("Received data:", data);  // ← wichtig!
                    const transformed = transformiereDaten(data); // data: ist JSON aus dem Backend
                    setDaten(transformed);
                })
            .catch(error => console.error('Error during loading of the statistics:', error));
    }, [customer_id]);

    return (
        <div>
            <h2>Strom-Kosten</h2>
            <CostChart daten={daten} />
        </div>
    );  // <pre>{JSON.stringify(daten, null, 2)}</pre> //zum Testen




}

export default StatistikSeite;
