import React from 'react';
import {
    BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer
} from 'recharts';

function CostChart({ daten }) {
    return (
        <div style={{ width: 500, height: 400 }}>
            <ResponsiveContainer width='100%' height={400}>
                <BarChart data={daten}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="monat" />
                    <YAxis />
                    <Tooltip />
                    {["Home", "Garage", "OuterSpace"].map(meteringPointAddr => (
                        <Bar key={meteringPointAddr} dataKey={meteringPointAddr} fill={meteringPointAddr === "Home" ? "#8884d8" : "#82ca9d"} />
                    ))}
                </BarChart>
            </ResponsiveContainer>
        </div>
    );
}

export default CostChart;
