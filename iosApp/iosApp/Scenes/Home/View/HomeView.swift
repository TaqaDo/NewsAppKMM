
import SnapKit
import UIKit

protocol HomeViewLogic: UIView {
    func getTableView() -> UITableView
    func getIndicator() -> UIActivityIndicatorView
}

final class HomeView: UIView {
    
    // MARK: - Views
    
    private lazy var tableView: UITableView = {
       let tableView = UITableView()
        tableView.register(NewsCell.self, forCellReuseIdentifier: NewsCell.cellID)
        tableView.backgroundColor = .white
        tableView.rowHeight = 250
        return tableView
    }()
    
    private lazy var activityIndicator: UIActivityIndicatorView = {
        let indicator = UIActivityIndicatorView(style: .large)
        indicator.hidesWhenStopped = true
        return indicator
    }()
    
    //
    
    // MARK: - Init
    
    override init(frame: CGRect = CGRect.zero) {
        super.init(frame: frame)
        configure()
    }
    
    required init?(coder _: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    // MARK: - Private Methods
    
    private func configure() {
        backgroundColor = .white
        addSubviews()
        addConstraints()
    }
    
    private func addSubviews() {
        addSubview(tableView)
        addSubview(activityIndicator)
    }
    
    private func addConstraints() {
        tableView.snp.makeConstraints { (make) in
            make.top.equalToSuperview()
            make.bottom.equalToSuperview()
            make.leading.trailing.equalToSuperview()
        }
        activityIndicator.snp.makeConstraints { make in
            make.center.equalToSuperview()
        }
    }
}

// MARK: - ProfileViewLogic

extension HomeView: HomeViewLogic {
    func getTableView() -> UITableView {
        return tableView
    }
    func getIndicator() -> UIActivityIndicatorView {
        return activityIndicator
    }
}
