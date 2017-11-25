package com.shepherdjerred.civilopedia.storage.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.district.District;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.project.Project;
import com.shepherdjerred.civilopedia.storage.Datastore;

import java.util.ArrayList;

public class SqliteDatastore extends SQLiteAssetHelper implements Datastore {

    private static final String DATABASE_NAME = "DebugGameplay.sqlite";
    private static final int DATABASE_VERSION = 1;

    public SqliteDatastore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public ArrayList<Building> getBuildings() {
        ArrayList<Building> buildings = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Buildings WHERE IsWonder == 0 ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = c.getString(1);
                String prereqTech = c.getString(2);
                String prereqCivic = c.getString(3);
                int cost = c.getInt(4);
                int maxPlayerInstances = c.getInt(5);
                int maxWorldInstances = c.getInt(6);
                boolean capital = c.getInt(7) != 0;
                String prereqDistrict = c.getString(8);
                String adjacentDistrict = c.getString(9);
                String description = c.getString(10);
                boolean requiresPlacement = c.getInt(11) != 0;
                boolean requiresRiver = c.getInt(12) != 0;
                int outerDefenseHitPoints = c.getInt(13);
                int housing = c.getInt(14);
                int entertainment = c.getInt(15);
                String adjacentResource = c.getString(16);
                boolean coast = c.getInt(17) != 0;
                boolean enabledByReligion = c.getInt(18) != 0;
                boolean allowsHolyCity = c.getInt(19) != 0;
                String purchaseYield = c.getString(20);
                boolean mustPurchase = c.getInt(21) != 0;
                int maintenance = c.getInt(22);
                boolean isWonder = c.getInt(23) != 0;
                String traitType = c.getString(24);
                int outerDefenseStrength = c.getInt(25);
                int citizenSlots = c.getInt(25);
                boolean mustBeLake = c.getInt(27) != 0;
                boolean mustNotBeLake = c.getInt(28) != 0;
                int regionalRange = c.getInt(29);
                boolean adjacentToMountain = c.getInt(30) != 0;
                String obsoleteEra = c.getString(31);
                boolean requiresReligion = c.getInt(32) != 0;
                int grantFortification = c.getInt(33);
                int defenseModifier = c.getInt(34);
                boolean internalOnly = c.getInt(35) != 0;
                boolean requiresAdjacentRiver = c.getInt(36) != 0;
                String quote = c.getString(37);
                String quoteAudio = c.getString(38);
                boolean mustBeAdjacentLand = c.getInt(39) != 0;
                boolean adjacentCapital = c.getInt(40) != 0;
                String adjacentImprovement = c.getString(41);
                String cityAdjacentTerrain = c.getString(42);
                boolean unlockGovernmentPolicy = c.getInt(43) != 0;
                String governmentTierRequirement = c.getString(44);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, maxPlayerInstances, maxWorldInstances,
                        capital, prereqDistrict, adjacentDistrict, description, requiresPlacement, requiresRiver, outerDefenseHitPoints,
                        housing, entertainment, adjacentResource, coast, enabledByReligion, allowsHolyCity, purchaseYield, mustPurchase,
                        maintenance, isWonder, traitType, outerDefenseStrength, citizenSlots, mustBeLake, mustNotBeLake, regionalRange,
                        adjacentToMountain, obsoleteEra, requiresReligion, grantFortification, defenseModifier, internalOnly, requiresAdjacentRiver,
                        quote, quoteAudio, mustBeAdjacentLand, adjacentCapital, adjacentImprovement, cityAdjacentTerrain, unlockGovernmentPolicy,
                        governmentTierRequirement);
                buildings.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return buildings;
    }

    @Override
    public ArrayList<Civilization> getCivilizations() {
        ArrayList<Civilization> civilizations = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Civilizations WHERE StartingCivilizationLevelType == 'CIVILIZATION_LEVEL_FULL_CIV' ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String civilizationType = c.getString(0);
                String name = c.getString(1);
                String description = c.getString(2);

                Civilization civilization = new Civilization(civilizationType, name, description);
                civilizations.add(civilization);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return civilizations;
    }

    @Override
    public ArrayList<Leader> getLeaders() {
        ArrayList<Leader> leaders = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Leaders WHERE InheritFrom == 'LEADER_DEFAULT' ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String leaderType = c.getString(0);
                String name = c.getString(1);

                Leader leader = new Leader(leaderType, name);
                leaders.add(leader);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return leaders;
    }

    @Override
    public ArrayList<CityState> getCityStates() {
        ArrayList<CityState> cityStates = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Civilizations WHERE StartingCivilizationLevelType == 'CIVILIZATION_LEVEL_CITY_STATE' ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String civilizationType = c.getString(0);
                String name = c.getString(1);
                String description = c.getString(2);

                CityState cityState = new CityState(civilizationType, name, description);
                cityStates.add(cityState);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return cityStates;
    }

    @Override
    public ArrayList<District> getDistricts() {
        ArrayList<District> districts = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Districts WHERE InternalOnly == 0 AND CityCenter != 1 ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String districtType = c.getString(0);
                String name = c.getString(1);
                String prereqTech = c.getString(2);
                String prereqCivic = c.getString(3);
                String description = c.getString(5);
                int cost = c.getInt(6);
                int hitPoints = c.getInt(15);

                District district = new District(districtType, name, prereqTech, prereqCivic, description, cost, hitPoints);
                districts.add(district);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return districts;
    }

    @Override
    public ArrayList<Building> getWonders() {
        ArrayList<Building> wonders = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Buildings WHERE IsWonder == 1 ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String buildingType = c.getString(0);
                String name = c.getString(1);
                String prereqTech = c.getString(2);
                String prereqCivic = c.getString(3);
                int cost = c.getInt(4);
                int maxPlayerInstances = c.getInt(5);
                int maxWorldInstances = c.getInt(6);
                boolean capital = c.getInt(7) != 0;
                String prereqDistrict = c.getString(8);
                String adjacentDistrict = c.getString(9);
                String description = c.getString(10);
                boolean requiresPlacement = c.getInt(11) != 0;
                boolean requiresRiver = c.getInt(12) != 0;
                int outerDefenseHitPoints = c.getInt(13);
                int housing = c.getInt(14);
                int entertainment = c.getInt(15);
                String adjacentResource = c.getString(16);
                boolean coast = c.getInt(17) != 0;
                boolean enabledByReligion = c.getInt(18) != 0;
                boolean allowsHolyCity = c.getInt(19) != 0;
                String purchaseYield = c.getString(20);
                boolean mustPurchase = c.getInt(21) != 0;
                int maintenance = c.getInt(22);
                boolean isWonder = c.getInt(23) != 0;
                String traitType = c.getString(24);
                int outerDefenseStrength = c.getInt(25);
                int citizenSlots = c.getInt(25);
                boolean mustBeLake = c.getInt(27) != 0;
                boolean mustNotBeLake = c.getInt(28) != 0;
                int regionalRange = c.getInt(29);
                boolean adjacentToMountain = c.getInt(30) != 0;
                String obsoleteEra = c.getString(31);
                boolean requiresReligion = c.getInt(32) != 0;
                int grantFortification = c.getInt(33);
                int defenseModifier = c.getInt(34);
                boolean internalOnly = c.getInt(35) != 0;
                boolean requiresAdjacentRiver = c.getInt(36) != 0;
                String quote = c.getString(37);
                String quoteAudio = c.getString(38);
                boolean mustBeAdjacentLand = c.getInt(39) != 0;
                boolean adjacentCapital = c.getInt(40) != 0;
                String adjacentImprovement = c.getString(41);
                String cityAdjacentTerrain = c.getString(42);
                boolean unlockGovernmentPolicy = c.getInt(43) != 0;
                String governmentTierRequirement = c.getString(44);

                Building building = new Building(buildingType, name, prereqTech, prereqCivic, cost, maxPlayerInstances, maxWorldInstances,
                        capital, prereqDistrict, adjacentDistrict, description, requiresPlacement, requiresRiver, outerDefenseHitPoints,
                        housing, entertainment, adjacentResource, coast, enabledByReligion, allowsHolyCity, purchaseYield, mustPurchase,
                        maintenance, isWonder, traitType, outerDefenseStrength, citizenSlots, mustBeLake, mustNotBeLake, regionalRange,
                        adjacentToMountain, obsoleteEra, requiresReligion, grantFortification, defenseModifier, internalOnly, requiresAdjacentRiver,
                        quote, quoteAudio, mustBeAdjacentLand, adjacentCapital, adjacentImprovement, cityAdjacentTerrain, unlockGovernmentPolicy,
                        governmentTierRequirement);
                wonders.add(building);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return wonders;
    }

    @Override
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Projects ORDER BY Name", null);
        if (c.moveToFirst()) {
            do {
                String projectType = c.getString(0);
                String name = c.getString(1);
                String shortName = c.getString(2);
                String description = c.getString(3);
                int cost = c.getInt(5);
                String prereqTech = c.getString(8);
                String prereqDistrict = c.getString(10);

                Project project = new Project(projectType, name, shortName, description, cost, prereqTech, prereqDistrict);
                projects.add(project);

            } while (c.moveToNext());
        }
        c.close();
        sqLiteDatabase.close();
        return projects;
    }


}