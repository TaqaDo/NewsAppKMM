import UIKit
import shared


final class HomeController: UIViewController {
    
    // MARK: - Public Properties
    
    lazy var contentView: HomeViewLogic = HomeView()
    private var viewModel = NewsAppSDK().viewModel.newsViewModel
    internal var news: NewsResponse?
    
    
    // MARK: - Private Properties
    
    //
    
    // MARK: - Lifecycle
    
    override func loadView() {
        view = contentView
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configure()
        observeViewModel()
        viewModel.getBreakingNews()
    }
    
    // MARK: - Requests
    
    //
    
    // MARK: - Private Methods
    
    private func observeViewModel() {
        viewModel.mNewsListLiveData.addObserver { newsState in
            if (newsState is SuccessNewsListState) {
                let successState = newsState as! SuccessNewsListState
                let response = successState.response as! ResponseSuccess
                let value = response.data as! NewsResponse
                self.news = value
                print("DEBUG: SUCCESS")
            } else if (newsState is LoadingNewsListState) {
                print("DEBUG: LOADING")
            } else if (newsState is ErrorNewsListState) {
                print("DEBUG: ERROR")
            }
        }
    }
    
    private func configure() {
        contentView.getTitle().text = "TALA"
    }
    
    // MARK: - UI Actions
    
    //
    
    deinit {
        viewModel.onCleared()
    }
}

