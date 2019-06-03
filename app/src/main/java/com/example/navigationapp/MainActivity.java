package com.example.navigationapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        NavController navController = host.getNavController();

        // setGraph method 1
        navController.setGraph(R.navigation.mobile_navigation);

        // setGraph method 2
        //NavGraphNavigator navGraphNavigator = new NavGraphNavigator(navController.getNavigatorProvider());
        //NavGraph destination = navGraphNavigator.createDestination();
        //
        //FragmentNavigator.Destination destination1 = new FragmentNavigator.Destination(navController.getNavigatorProvider());
        //destination1.setId(R.id.dest_home);
        //destination1.setLabel(getString(R.string.home));
        //destination1.setClassName(HomeFragment.class.getName());
        //destination.addDestination(destination1);
        //
        //FragmentNavigator.Destination destination2 = new FragmentNavigator.Destination(navController.getNavigatorProvider());
        //destination2.setId(R.id.dest_deep_link);
        //destination2.setLabel(getString(R.string.deeplink));
        //destination2.setClassName(DeepLinkFragment.class.getName());
        //destination.addDestination(destination2);
        //
        //navController.getNavigatorProvider().addNavigator(navGraphNavigator);
        //destination.setStartDestination(R.id.dest_home);
        //navController.setGraph(destination);

        Iterator<NavDestination> navDestinationIterator = navController.getGraph().iterator();
        Set<Integer> set = new HashSet<>();
        while (navDestinationIterator.hasNext()) {
            set.add(navDestinationIterator.next().getId());
        }
        appBarConfiguration = new AppBarConfiguration.Builder(set).build();
        setupActionBar(navController, appBarConfiguration);

        setupBottomNavMenu(navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                String resourceName = getResources().getResourceName(destination.getId());
                Toast.makeText(MainActivity.this, resourceName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupActionBar(NavController navController, AppBarConfiguration appBarConfig) {
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
    }

    private void setupBottomNavMenu(NavController navController) {
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        boolean optionsMenu = super.onCreateOptionsMenu(menu);

        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        // The NavigationView already has these same navigation items, so we only add
        // navigation items to the menu here if there isn't a NavigationView
        if (navigationView == null) {
            getMenuInflater().inflate(R.menu.overflow_menu, menu);
            return true;
        }
        return optionsMenu;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);

        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(this, R.id.my_nav_host_fragment))
                || super.onOptionsItemSelected(item);
    }
}
