/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xebia.mower;

import com.xebia.mower.domain.Field;
import com.xebia.mower.domain.Mower;
import com.xebia.mower.domain.Lawn;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sébastien
 */
public class XebiaMowerSimulator {

    public static void main(String[] args) {
        String filename = args[0];

        try {
            Reader reader = new FileReader(new File(filename));
            XebiaConfigurationParser parser = new XebiaConfigurationParser(reader);
            XebiaSimulatorConfiguration conf = parser.parse();
            new XebiaMowerSimulator().run(conf);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XebiaMowerSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run(XebiaSimulatorConfiguration configuration) {
        Field field = new Field(configuration.getXTopRightCorner(), configuration.getYTopRightCorner());
        
        for (XebiaMowerInstruction instruction : configuration.getMowerConfigurations()) {
            Lawn lawn = field.getLawn(instruction.getXStartPosition(), instruction.getYStartPosition());
            Mower mower = new Mower(lawn, instruction.getOrientation());
            mower.move(instruction);
        }
    }
}
