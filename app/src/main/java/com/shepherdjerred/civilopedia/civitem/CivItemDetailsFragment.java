package com.shepherdjerred.civilopedia.civitem;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.shepherdjerred.civilopedia.ActionBarFragment;
import com.shepherdjerred.civilopedia.civitem.Resources.Resource;
import com.shepherdjerred.civilopedia.civitem.Resources.ResourceDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.building.Building;
import com.shepherdjerred.civilopedia.civitem.building.BuildingDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.citystate.CityState;
import com.shepherdjerred.civilopedia.civitem.citystate.CityStateDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.civic.Civic;
import com.shepherdjerred.civilopedia.civitem.civic.CivicDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.civilization.Civilization;
import com.shepherdjerred.civilopedia.civitem.civilization.CivilizationDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.district.District;
import com.shepherdjerred.civilopedia.civitem.district.DistrictDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.feature.Feature;
import com.shepherdjerred.civilopedia.civitem.feature.FeatureDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.government.Government;
import com.shepherdjerred.civilopedia.civitem.government.GovernmentDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.great_person.GreatPerson;
import com.shepherdjerred.civilopedia.civitem.great_person.GreatPersonDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.improvements.Improvement;
import com.shepherdjerred.civilopedia.civitem.improvements.ImprovementDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.leader.Leader;
import com.shepherdjerred.civilopedia.civitem.leader.LeaderDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.policy.Policy;
import com.shepherdjerred.civilopedia.civitem.policy.PolicyDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.project.Project;
import com.shepherdjerred.civilopedia.civitem.project.ProjectDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.religion.Religion;
import com.shepherdjerred.civilopedia.civitem.religion.ReligionDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.route.Route;
import com.shepherdjerred.civilopedia.civitem.route.RouteDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.technology.Technology;
import com.shepherdjerred.civilopedia.civitem.technology.TechnologyDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.terrain.Terrain;
import com.shepherdjerred.civilopedia.civitem.terrain.TerrainDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.unit.Unit;
import com.shepherdjerred.civilopedia.civitem.unit.UnitDetailsFragment;
import com.shepherdjerred.civilopedia.civitem.unit_promotion.UnitPromotion;
import com.shepherdjerred.civilopedia.civitem.unit_promotion.UnitPromotionDetailsFragment;

public abstract class CivItemDetailsFragment extends Fragment implements ActionBarFragment {

    private OnFragmentInteractionListener mListener;

    private static final String ARG_CIV_ITEM = "civ_item";
    protected CivItem civItem;

    public static CivItemDetailsFragment newInstance(CivItem civItem) {

        Log.d("CivItem", civItem.toString());

        CivItemDetailsFragment civItemDetailsFragment;

        if (civItem instanceof Civilization) {
            civItemDetailsFragment = new CivilizationDetailsFragment();
        } else if (civItem instanceof Leader) {
            civItemDetailsFragment = new LeaderDetailsFragment();
        } else if (civItem instanceof CityState) {
            civItemDetailsFragment = new CityStateDetailsFragment();
        } else if (civItem instanceof District) {
            civItemDetailsFragment = new DistrictDetailsFragment();
        } else if (civItem instanceof Building) {
            civItemDetailsFragment = new BuildingDetailsFragment();
        } else if (civItem instanceof Project) {
            civItemDetailsFragment = new ProjectDetailsFragment();
        } else if (civItem instanceof Unit) {
            civItemDetailsFragment = new UnitDetailsFragment();
        } else if (civItem instanceof Route) {
            civItemDetailsFragment = new RouteDetailsFragment();
        } else if (civItem instanceof Improvement) {
            civItemDetailsFragment = new ImprovementDetailsFragment();
        } else if (civItem instanceof Resource) {
            civItemDetailsFragment = new ResourceDetailsFragment();
        } else if (civItem instanceof Feature) {
            civItemDetailsFragment = new FeatureDetailsFragment();
        } else if (civItem instanceof Terrain) {
            civItemDetailsFragment = new TerrainDetailsFragment();
        } else if (civItem instanceof Religion) {
            civItemDetailsFragment = new ReligionDetailsFragment();
        } else if (civItem instanceof Policy) {
            civItemDetailsFragment = new PolicyDetailsFragment();
        } else if (civItem instanceof Government) {
            civItemDetailsFragment = new GovernmentDetailsFragment();
        } else if (civItem instanceof Civic) {
            civItemDetailsFragment = new CivicDetailsFragment();
        } else if (civItem instanceof Technology) {
            civItemDetailsFragment = new TechnologyDetailsFragment();
        } else if (civItem instanceof GreatPerson) {
            civItemDetailsFragment = new GreatPersonDetailsFragment();
        } else if (civItem instanceof UnitPromotion) {
            civItemDetailsFragment = new UnitPromotionDetailsFragment();
        } else {
            throw new UnsupportedOperationException();
        }

        Bundle args = new Bundle();
        args.putParcelable(ARG_CIV_ITEM, civItem);
        civItemDetailsFragment.setArguments(args);
        return civItemDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            civItem = getArguments().getParcelable(ARG_CIV_ITEM);
        }
    }

    // TODO Should probably make this method abstract?
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onCivItemDetailsFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onCivItemDetailsFragmentInteraction(Uri uri);
    }

    @Override
    public String getToolbarTitle() {
        return civItem.getName();
    }
}
