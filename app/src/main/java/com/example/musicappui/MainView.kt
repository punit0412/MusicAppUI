package com.example.musicappui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.primarySurface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MainView(modifier: Modifier){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    val viewModel: MainViewModel = viewModel()

    val isSheetFullScreen = remember { mutableStateOf(false) }
    val modifier = if(isSheetFullScreen.value) Modifier.fillMaxSize() else Modifier.fillMaxWidth()


    // Allow us to find out on which view we currently are
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //-----------------------------------------------------------

    val dialogOpen = remember { mutableStateOf(false) }

    val currentScreen = remember { viewModel.currentScreen.value }
    val title  = remember {
        // change that to currentScreen.title
        mutableStateOf(currentScreen.title)}

    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = {it!= ModalBottomSheetValue.HalfExpanded}
    )

    val roundedCornerRadius = if (isSheetFullScreen.value) 0.dp else 12.dp

    val buttomBar: @Composable () -> Unit = {


        if (currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home){

            BottomNavigation(modifier = Modifier.wrapContentSize().padding(bottom = 8.dp)) {
                screensInBottom.forEach {
                    item ->
                    val isSelected = currentRoute == item.bRoute
                    val tint = if(isSelected) Color.White else Color.Black
                    BottomNavigationItem(
                        selected = currentRoute == item.bRoute,
                        onClick = {
                            controller.navigate(item.bRoute)
                            title.value = item.bTitle

                                  },
                        icon = {
                            Icon(painter = painterResource(item.icon),
                                contentDescription = item.bTitle, tint = tint)
                        },
                        label = {Text(item.bTitle, color = tint)},
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black
                    )
                }
            }
        }

    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(roundedCornerRadius, topEnd = roundedCornerRadius),
        sheetContent = {
        MoreBottomSheet(modifier = modifier)
    }) {

        Scaffold(
            bottomBar = buttomBar,
            topBar = {
                TopAppBar(
                    title = { Text(title.value) },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                if (modalSheetState.isVisible){
                                    modalSheetState.hide()
                                }else{
                                    modalSheetState.show()
                                }
                            }
                        }) {

                            Icon(Icons.Default.MoreVert, contentDescription = "Action Button")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            // open the drawer
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "menu")
                        }
                    })

            },
            scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(Modifier.padding(16.dp).statusBarsPadding()) {
                    items(screensInDrawer){
                            item -> DrawerItem(currentRoute == item.dRoute,item) {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        if(item.dRoute == "add_account"){
                            // open dialog
                            dialogOpen.value = true
                        }else{
                            controller.navigate(item.dRoute)
                            title.value = item.dTitle
                        }
                    }

                    }
                }
            }


        ) {
            Navigation(controller,viewModel,it)
            AccountDialog(dialogOpen = dialogOpen)
        }
    }
    }




@Composable
fun MoreBottomSheet(modifier: Modifier){

    Box(Modifier.fillMaxWidth().
    height(300.dp).
    background(MaterialTheme.colors.primarySurface)){

        Column(modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Row(modifier = Modifier.padding(16.dp)) {

                IconButton(onClick = {}){
                    Icon(modifier = Modifier.padding(end = 8.dp),
                        painter = painterResource(R.drawable.baseline_settings_24),
                        contentDescription = "Settings")
                }

                Text("Settings", fontSize = 20.sp, color = Color.White)


            }
        }

    }

}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit
){
    val background = if(selected) Color.Green else Color.White

    Row(
        Modifier.fillMaxWidth().
        padding(horizontal = 8.dp, vertical = 16.dp).background(background).
        clickable{
            onDrawerItemClicked()
        }
    ) {

        Icon(
            painter = painterResource(item.icon),
            contentDescription = item.dTitle,
            Modifier.padding(end = 8.dp, top = 4.dp)
        )

        Text(text = item.dTitle,
            style = MaterialTheme.typography.h5)

    }

}

@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd: PaddingValues){

    NavHost(navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.route,
        modifier = Modifier.padding(pd)) {

        composable(Screen.DrawerScreen.Account.route) {
            AccountView()

        }





        composable(Screen.DrawerScreen.Subscription.route) {

            SubscriptionView()

        }

        composable(Screen.BottomScreen.Home.route) {
            Home()
        }

        composable(Screen.BottomScreen.Library.route) {
            LibraryView()

        }

        composable(Screen.BottomScreen.Browse.route) {
            Browse()
        }

    }

}