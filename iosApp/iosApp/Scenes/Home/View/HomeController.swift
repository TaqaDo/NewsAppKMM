import UIKit
import shared


final class HomeController: UIViewController {
    
    // MARK: - Public Properties
    
    lazy var contentView: HomeViewLogic = HomeView()
    private var viewModel = NewsAppSDK().viewModel.newsViewModel
    var articles: [Article] = [] {
        didSet {
            self.contentView.getIndicator().stopAnimating()
            self.contentView.getTableView().reloadData()
        }
    }
    
    
    // MARK: - Private Properties
    
    //
    
    // MARK: - Lifecycle
    
    override func loadView() {
        view = contentView
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configure()
        delegates()
        observables()
        getBreakingNews()
    }
    
    // MARK: - Requests
    
    private func getBreakingNews() {
        viewModel.getBreakingNews()
    }
    
    //
    
    // MARK: - Private Methods
    
    private func observables() {
        viewModel.mNewsListLiveData.addObserver { newsState in
            if (newsState is SuccessNewsListState) {
                let successState = newsState as! SuccessNewsListState
                let response = successState.response as! ResponseSuccess
                guard let value = response.data else {return}
                self.articles = value.articles!
                print("DEBUG: SUCCESS")
            } else if (newsState is LoadingNewsListState) {
                self.contentView.getIndicator().startAnimating()
            } else if (newsState is ErrorNewsListState) {
                print("DEBUG: ERROR")
            }
        }
    }
    
    private func configure() {
        
    }
    
    private func delegates() {
        contentView.getTableView().delegate = self
        contentView.getTableView().dataSource = self
    }
    
    // MARK: - UI Actions
    
    //
    
    deinit {
        viewModel.onCleared()
    }
}

extension HomeController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return articles.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: NewsCell.cellID,
                                                       for: indexPath) as? NewsCell else {return UITableViewCell()}
        let item = articles[indexPath.row]
        cell.setupData(data: item)
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
    }

}

