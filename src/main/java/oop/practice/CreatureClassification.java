package oop.practice;

import java.util.List;

public class CreatureClassification {

    public String classifyCreature(Creature creature, List<Creature> starWars, List<Creature> hitchhikers, List<Creature> marvel, List<Creature> rings) {
        String classification = null;

        // Star Wars classification
        if (!creature.isHumanoid() && "Kashyyyk".equalsIgnoreCase(creature.getUniverse())) {
            starWars.add(creature);
            classification = "StarWars";
        } else if (!creature.isHumanoid() && "Endor".equalsIgnoreCase(creature.getUniverse())) {
            starWars.add(creature);
            classification = "StarWars";
        } else if (creature.getTraits().contains("HAIRY") && creature.getTraits().contains("TALL") && creature.getAge() <= 400) {
            starWars.add(creature);
            classification = "StarWars";
        } else if (creature.getTraits().contains("SHORT") && creature.getTraits().contains("HAIRY") && creature.getAge() <= 60) {
            starWars.add(creature);
            classification = "StarWars";
        }

        // Lord of the Rings classification
        else if ("Earth".equalsIgnoreCase(creature.getUniverse())) {
            if (creature.isHumanoid() && creature.getTraits().contains("BLONDE") && creature.getTraits().contains("POINTY_EARS")) {
                rings.add(creature);
                classification = "Lord of the Rings";
            } else if (creature.isHumanoid() && creature.getTraits().contains("SHORT") && creature.getTraits().contains("BULKY")) {
                rings.add(creature);
                classification = "Lord of the Rings";
            } else if (creature.isHumanoid() && creature.getAge() > 200) {
                rings.add(creature);
                classification = "Lord of the Rings";
            } else if (creature.getTraits().contains("BLONDE") && creature.getTraits().contains("TALL")) {
                rings.add(creature);
                classification = "Lord of the Rings";
            } else {
                rings.add(creature);
                classification = "Lord of the Rings";
            }
        }

        // Marvel classification
        else if (creature.isHumanoid() && "Asgard".equalsIgnoreCase(creature.getUniverse())) {
            marvel.add(creature);
            classification = "Marvel";
        } else if (creature.getTraits().contains("BLONDE") && creature.getTraits().contains("TALL") && creature.getAge() <= 5000) {
            marvel.add(creature);
            classification = "Marvel";
        }

        // Hitchhikers classification
        else if (creature.isHumanoid() && "Betelgeuse".equalsIgnoreCase(creature.getUniverse())) {
            hitchhikers.add(creature);
            classification = "Hitchhikers";
        } else if (creature.getTraits().contains("EXTRA_ARMS") || creature.getTraits().contains("EXTRA_HEAD")) {
            hitchhikers.add(creature);
            classification = "Hitchhikers";
        } else if (!creature.isHumanoid() && (creature.getTraits().contains("GREEN") || creature.getTraits().contains("BULKY"))) {
            hitchhikers.add(creature);
            classification = "Hitchhikers";
        }

        // Additional conditions for Lord of the Rings
        else if (creature.isHumanoid() && creature.getTraits().contains("BULKY")) {
            rings.add(creature);
            classification = "Lord of the Rings";
        } else if (creature.isHumanoid() && creature.getAge() > 1000) {
            rings.add(creature);
            classification = "Lord of the Rings";
        }

        return classification;
    }
}
